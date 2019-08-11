package com.chuangdun.arcface.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author nick
 */
@ConfigurationProperties(prefix = "face.sdk", ignoreUnknownFields = false)
public class ArcEngineProperties {
    private boolean enabled;

    private String location;
    private String appId;
    private String sdkKey;

    private boolean faceDetectEnabled;
    private boolean faceRecognitionEnabled;
    private boolean ageDetectEnabled;
    private boolean genderDetectEnabled;
    private boolean face3dAngleEnabled;
    private boolean livenessEnabled;
    private boolean irLivenessEnabled;

    public ArcEngineProperties() {
        this.enabled = true;
        this.faceDetectEnabled = true;
        this.faceRecognitionEnabled = true;
        this.ageDetectEnabled = false;
        this.genderDetectEnabled = false;
        this.face3dAngleEnabled = false;
        this.livenessEnabled = false;
        this.irLivenessEnabled = false;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSdkKey() {
        return sdkKey;
    }

    public void setSdkKey(String sdkKey) {
        this.sdkKey = sdkKey;
    }

    public boolean isFaceDetectEnabled() {
        return faceDetectEnabled;
    }

    public void setFaceDetectEnabled(boolean faceDetectEnabled) {
        this.faceDetectEnabled = faceDetectEnabled;
    }

    public boolean isFaceRecognitionEnabled() {
        return faceRecognitionEnabled;
    }

    public void setFaceRecognitionEnabled(boolean faceRecognitionEnabled) {
        this.faceRecognitionEnabled = faceRecognitionEnabled;
    }

    public boolean isAgeDetectEnabled() {
        return ageDetectEnabled;
    }

    public void setAgeDetectEnabled(boolean ageDetectEnabled) {
        this.ageDetectEnabled = ageDetectEnabled;
    }

    public boolean isGenderDetectEnabled() {
        return genderDetectEnabled;
    }

    public void setGenderDetectEnabled(boolean genderDetectEnabled) {
        this.genderDetectEnabled = genderDetectEnabled;
    }

    public boolean isFace3dAngleEnabled() {
        return face3dAngleEnabled;
    }

    public void setFace3dAngleEnabled(boolean face3dAngleEnabled) {
        this.face3dAngleEnabled = face3dAngleEnabled;
    }

    public boolean isLivenessEnabled() {
        return livenessEnabled;
    }

    public void setLivenessEnabled(boolean livenessEnabled) {
        this.livenessEnabled = livenessEnabled;
    }

    public boolean isIrLivenessEnabled() {
        return irLivenessEnabled;
    }

    public void setIrLivenessEnabled(boolean irLivenessEnabled) {
        this.irLivenessEnabled = irLivenessEnabled;
    }

    @Override
    public String toString() {
        return "ArcEngineProperties{" +
                "enabled=" + enabled +
                ", location='" + location + '\'' +
                ", appId='" + appId + '\'' +
                ", sdkKey='" + sdkKey + '\'' +
                ", faceDetectEnabled=" + faceDetectEnabled +
                ", faceRecognitionEnabled=" + faceRecognitionEnabled +
                ", ageDetectEnabled=" + ageDetectEnabled +
                ", genderDetectEnabled=" + genderDetectEnabled +
                ", face3dAngleEnabled=" + face3dAngleEnabled +
                ", livenessEnabled=" + livenessEnabled +
                ", irLivenessEnabled=" + irLivenessEnabled +
                '}';
    }
}
