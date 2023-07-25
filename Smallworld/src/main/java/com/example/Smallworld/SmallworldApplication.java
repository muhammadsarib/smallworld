package com.example.Smallworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.json.simple.parser.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Smallworld.data.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class SmallworldApplication {

	
	public static void main(String[] args) throws IOException {
		
		SpringApplication.run(SmallworldApplication.class, args);

		TransactionDataFetcher data=new TransactionDataFetcher();
		System.out.println(data.getTotalTransactionAmount());
		System.out.println(data.getTotalTransactionAmountSentBy("Aunt Polly"));
		System.out.println(data.countUniqueClients());
		System.out.println(data.hasOpenComplianceIssues("Aunt Polly"));
		System.out.println(data.getTransactionsByBeneficiaryName().toString());
		System.out.println(data.getUnsolvedIssueIds());
		System.out.println(data.getTop3TransactionsByAmount());
		
		
	}

}
