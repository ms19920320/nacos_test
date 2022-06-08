package com.citycloud.nacostest.score;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * @author 孟帅
 * @since 2022/6/8
 */
public class Test {
    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException {
        // producerMessage();
        consumerMessage();
    }

    private static void producerMessage() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        //1. 创建消息生产者, 指定生产者所属的组名
        DefaultMQProducer producer = new DefaultMQProducer("myproducer-group");
        //2. 指定Nameserver地址
        producer.setNamesrvAddr("120.46.181.75:9876");
        //3. 启动生产者
        producer.start();
        //4. 创建消息对象，指定主题、标签和消息体
        Message msg = new Message("myTopic", "myTag", ("RocketMQ Message" + System.currentTimeMillis()).getBytes());

        //5. 发送消息
        SendResult sendResult = producer.send(msg, 10000);
        System.out.println(sendResult);
        //6. 关闭生产者
        producer.shutdown();
    }

    private static void consumerMessage() throws MQClientException, RemotingException, MQBrokerException, InterruptedException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer-group");
        // 2.为消费者设置NameServer的地址
        consumer.setNamesrvAddr("120.46.181.75:9876");

        // 3.指定消费者订阅的主题和标签
        consumer.subscribe("myTopic", "*");
        // 4.设置一个回调函数，并在函数中编写接收到的消息之后的处理办法
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                // 消费逻辑
                System.out.println("message=====> " + JSONObject.toJSONString(list));
                // 返回消费成功状态
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        // 3.启动生产者
        consumer.start();
        System.out.println("启动消费者成功了");
    }
}
