package com.pulkit.couch.service.impl;

import com.couchbase.client.vbucket.config.Bucket;
import com.pulkit.couch.service.StudentService;

public class StudentServiceImpl implements StudentService {

	public void getById(Integer id) {
		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket();
		JsonDocument walter = bucket.get("walter");
		System.out.println("Found: " + walter)

	}

}
