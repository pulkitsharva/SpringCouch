package com.pulkit.couch.service.impl;

import org.springframework.stereotype.Service;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.pulkit.couch.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	public void getById(Integer id) {
		Cluster cluster = CouchbaseCluster.create();
		Bucket bucket = cluster.openBucket("student","admin");
		JsonDocument walter = bucket.get(id.toString());
		System.out.println("Found: " + walter);

	}

}
