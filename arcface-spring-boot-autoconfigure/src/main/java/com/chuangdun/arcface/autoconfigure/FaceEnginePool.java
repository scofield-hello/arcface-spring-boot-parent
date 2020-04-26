package com.chuangdun.arcface.autoconfigure;

import com.arcsoft.face.FaceEngine;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class FaceEnginePool extends GenericObjectPool<FaceEngine> {

    public FaceEnginePool(PooledObjectFactory<FaceEngine> factory, GenericObjectPoolConfig<FaceEngine> config) {
        super(factory, config);
    }
}
