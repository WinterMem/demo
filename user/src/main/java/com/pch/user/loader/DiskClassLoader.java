package com.pch.user.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.pch.user.dto.UserDto;

/**
 * @author: pch
 * @date: 2020/8/14
 */
public class DiskClassLoader extends ClassLoader {

    private final String classPath;

    public DiskClassLoader(String classPath) {
        super();
        this.classPath = classPath;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // 判断当前加载的类是否是需要动态重新加载的类，
        // 假如是通过重写的findClass在自定义的ClassLoader里面加载，
        // 假如不是就调用父ClassLoader默认加载
        if (name != null && name.equals(classPath)) {
            return findClass(name);
        }
        return super.loadClass(name, false);
    }

    /**
     * 根据类名查找class
     *
     * @param fullClassPath 类全路径（包）
     * @return
     */
    @Override
    protected Class<?> findClass(String fullClassPath) {
        byte[] raw = readClassBytes(fullClassPath);
        // definClass方法参数说明：name：类包的全路径如com.lkb.sb.client.shanghaiC.ShangHaiLoginClient
        //                         b：读取的class文件的byte数组
        //                         off：从byte数组中读取的索引
        //                         len：从byte数组中读取的长度
        // 注：假如此类中有引入别的class类，如com.lkb.sb.client.BaseClient，循环执行findClass方法
        Class<?> clazz = defineClass(fullClassPath, raw, 0, raw.length);
        // 连接class
        resolveClass(clazz);
        return clazz;
    }

    /**
     * 读取class
     *
     * @param fullClassPath
     * @return
     */
    private byte[] readClassBytes(String fullClassPath) {
        byte[] raw = null;
        InputStream stream = null;
        try {
            System.out.println(UserDto.class.getResource("/").toString());
            File file = new File(UserDto.class.getResource("/").toString().replace("file:", "") + fullClassPath.replace(".","/") + ".class");
            stream = new FileInputStream(file);
            raw = new byte[(int) file.length()];
            stream.read(raw);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (Exception e) {
            }
        }
        return raw;
    }
}
