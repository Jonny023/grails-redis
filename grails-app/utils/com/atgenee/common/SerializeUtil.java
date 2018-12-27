package com.atgenee.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author Lee
 * @Description
 * @Date 2018年12月27日 21:53
 */
public enum SerializeUtil {

    INSTANCE;

    /**
     * 序列化
     *
     * @param object
     * @return
     */
    public byte[] serialize(Object object) {

        ObjectOutputStream oos = null;

        ByteArrayOutputStream baos = null;

        try {

            //序列化
            baos = new ByteArrayOutputStream();

            oos = new ObjectOutputStream(baos);

            oos.writeObject(object);

            byte[] bytes = baos.toByteArray();

            return bytes;

        } catch (Exception e) {

        }

        return null;
    }


    /**
     * 反序列化
     *
     * @param bytes
     * @return
     */
    public Object unserialize(byte[] bytes) {

        ByteArrayInputStream bais = null;

        try {

            //反序列化
            bais = new ByteArrayInputStream(bytes);

            ObjectInputStream ois = new ObjectInputStream(bais);

            return ois.readObject();

        } catch (Exception e) {

        }

        return null;
    }
}
