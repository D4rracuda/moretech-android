package com.lydone.sharebillandroid.share_bill

import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import com.rabbitmq.client.*

class RabbitMQHandlerThread(private val viewModel: ShareBillViewModel) :
    HandlerThread("RabbitMQThread") {
    private var workerHandler: Handler? = null
    private var mainHandler = Handler(Looper.getMainLooper())
    private var connection: Connection? = null
    private var channel: Channel? = null
    private val exchangeName = "TEST"
    private val routingKey = ""

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        workerHandler = Handler(looper)
        workerHandler!!.post {
            val factory = ConnectionFactory()
            factory.setUri("amqp://jkrzhztm:KhwYvr2Ud8mHQICpK0-pIXhkNltDKzE_@dove.rmq.cloudamqp.com/jkrzhztm")
            try {
                connection = factory.newConnection()
            } catch (e: Exception) {
                Log.e("TAG", e.message, e)
            }
            channel = connection!!.createChannel()
            channel!!.exchangeDeclare(exchangeName, "fanout")
            // hash of userName
            val queueName = channel!!.queueDeclare("MyQueue1", false, false, false, emptyMap()).queue
            channel!!.queueBind(queueName, exchangeName, routingKey)
            channel!!.basicConsume(queueName, false, object: DefaultConsumer(channel) {
                override fun handleDelivery(
                    consumerTag: String?,
                    envelope: Envelope?,
                    properties: AMQP.BasicProperties?,
                    body: ByteArray?
                ) {
                    val response = String(body!!)
                    viewModel.processMessage(response)
                    channel.basicAck(envelope!!.deliveryTag, true)
                }
            })
        }
    }

    fun postMessage(message: String) {
        workerHandler!!.post {
            channel!!.basicPublish(
                exchangeName,
                routingKey,
                AMQP.BasicProperties.Builder().contentType("application/json").build(),
                message.toByteArray()
            )
        }

    }

}