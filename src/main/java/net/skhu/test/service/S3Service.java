package net.skhu.test.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by ds on 2017-11-09.
 */
@Service
public class S3Service {

    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    //S3에 파일을 업로드한다.
    public void uploadOnS3(String fileName, File file) {

        TransferManager transferManager = new TransferManager(this.amazonS3);
        PutObjectRequest request = new PutObjectRequest(bucket, fileName, file);
        Upload upload = transferManager.upload(request);

        try {
            upload.waitForCompletion();
        } catch (AmazonClientException amazonClientException) {
            amazonClientException.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}