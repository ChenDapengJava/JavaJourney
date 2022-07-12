package com.xblzer.fastdfs.utils;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;

import java.io.*;
import java.util.Arrays;

/**
 * 分布式文件系统FastDFS 操作客户端
 * @author 行百里er
 * @date 2022-06-25 18:08
 */
public class FastDfsClient {

    private static final String FASTDFS_CONFIG_FILE_NAME = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "fdfs_client.conf";

    private static StorageClient storageClient = null;

    static {
        try {
            ClientGlobal.init(FASTDFS_CONFIG_FILE_NAME);
            // 追踪服务
            TrackerClient trackerClient = new TrackerClient(ClientGlobal.getG_tracker_group());
            TrackerServer trackerServer = trackerClient.getConnection();
            // 存储服务。追踪器充当客户端和存储服务的媒介，将存储服务的信息获取到
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient = new StorageClient(trackerServer, storageServer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 上传文件
     * @param file 文件
     * @param fileName 文件名
     * @return 返回一个数组，第一个元素是组名称，第二个元素时图片名称
     */
    public static String[] uploadFile(File file, String fileName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int len = fis.available();
            byte[] fileBuff = new byte[len];
            fis.read(fileBuff);

            return storageClient.upload_file(fileBuff, getFileExt(fileName), null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据组名和远程文件名来删除一个文件
     *
     * @param groupName
     *            例如 "group1" 如果不指定该值，默认为group1
     * @param remoteFileName
     *            例如"M00/00/00/wKgxgk5HbLvfP86RAAAAChd9X1Y736.jpg"
     * @return 0为成功，非0为失败，具体为错误代码
     */
    public static int deleteFile(String groupName, String remoteFileName) {
        try {
            return storageClient.delete_file(groupName == null ? "group1" : groupName, remoteFileName);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * 修改一个已经存在的文件
     *
     * @param oldGroupName
     *            旧的组名
     * @param oldFileName
     *            旧的文件名
     * @param file
     *            新文件
     * @param fileName
     *            新文件名
     * @return 返回空则为失败
     */
    public static String[] modifyFile(String oldGroupName, String oldFileName, File file, String fileName) {
        String[] fileIds;
        try {
            // 先上传
            fileIds = uploadFile(file, fileName);
            if (fileIds == null) {
                return null;
            }
            // 再删除
            int delResult = deleteFile(oldGroupName, oldFileName);
            if (delResult != 0) {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
        return fileIds;
    }

    /**
     * 文件下载
     *
     * @param groupName 组名
     * @param remoteFileName 文件名
     * @return 返回一个流
     */
    public static InputStream downloadFile(String groupName, String remoteFileName) {
        try {
            byte[] bytes = storageClient.download_file(groupName, remoteFileName);
            return new ByteArrayInputStream(bytes);
        } catch (Exception ex) {
            return null;
        }
    }


    public static NameValuePair[] getMetaData(String groupName, String remoteFileName){
        try{
            return storageClient.get_metadata(groupName, remoteFileName);
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 获取文件后缀名（不带点）.
     *
     * @return 如："jpg" or "".
     */
    private static String getFileExt(String fileName) {
        if (StringUtils.isBlank(fileName) || !fileName.contains(".")) {
            return "";
        } else {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
    }

    public static void main(String[] args) {
        // 上传
//        File file = new File("D:/apptest/test.jpg");
//        String fileName = "test.jpg";
//        String[] uploadResult = uploadFile(file, fileName);
//        System.out.println(Arrays.toString(uploadResult));

        // 下载
        try {
            // 上传时有个返回结果包含group和文件磁盘及文件名信息
            InputStream is = downloadFile("group1", "M00/00/00/wKjycGK25DSAM3pvAAGQJOaIBGg984.jpg");
            OutputStream os = new FileOutputStream("D:/fastdfs.png");
            int index;
            while((index = is.read())!=-1){
                os.write(index);
            }
            os.flush();
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
