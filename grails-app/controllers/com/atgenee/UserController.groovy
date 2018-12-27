package com.atgenee

import grails.plugins.redis.RedisService
import org.hibernate.Session

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    def redisService

    def userService

    /**
     * 批量添加5W条数据
     */
    @Transactional
    def batchAdd() {
        User.withSession { Session session->
            (0..49999).eachWithIndex{ int entry, int i ->
                new User("张三_$i".toString(),"第${i}个用户：张三${i}".toString()).save()
                if(i % 1000 == 0) {
                    session.flush()
                    session.clear()
                }
            }
        }
        render "用户添加完成"
    }

    /**
     *  数据存入redis中
     * @return
     */
    def createRedisData() {
        userService.save()
        userService.list()
        render "存入redis"
    }

    /**
     *  获取redis中的数据
     * @param max
     * @return
     */
    def list() {
        render redisService.nickname + "," +redisService.age + ","+redisService.sex
    }


    /**
     *  清理redis中所有数据
     */
    def clean() {
        userService.clean()
        render "清空redis所有数据"
    }

    /**
     *  清理redis中指定的key
     */
    def removeOfKey() {
        userService.deleteOfKey("ag*")
        render "清空redis所有数据"
    }

    /**
     *  获取redis中序列化的userList字符串
     */
    def getUsers() {
        render redisService.userList?:"暂无数据"
    }

    /**
     *  将学生信息序列化后存入redis
     */
    def store() {
        userService.store()
        render "序列化学生信息"
    }

    /**
     *  反序列化读取学生信息
     */
    def get() {
        def student = userService.get(1L)
        render "反序列化学生信息："+student.toString()
    }


}
