package com.example.Smallworld;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.parser.*;

import org.json.JSONArray;
import org.json.JSONObject;

import com.example.Smallworld.data.Transaction;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TransactionDataFetcher {

   
 

public List<Transaction> TransactionData() throws StreamReadException, DatabindException, IOException {	
	File file = new File("G:/Sarib_software_data/Smallworld/transactions.json");
	FileReader reader = new FileReader(file);
	ObjectMapper mapper =  new ObjectMapper();
	FileInputStream stream = new FileInputStream(file);
	Transaction[] obj = mapper.readValue(stream, Transaction[].class);
	 List<Transaction> trans = Arrays.asList(obj);
	return trans;
}


		/**
		 * Returns the sum of the amounts of all transactions
		 * @throws IOException 
		 * @throws DatabindException 
		 * @throws StreamReadException 
		 */
	
    public double getTotalTransactionAmount() throws StreamReadException, DatabindException, IOException {
    	
    	//done
    	
    return	TransactionData().stream().mapToDouble(t -> t.getAmount()).sum();
    	 
        
    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public double getTotalTransactionAmountSentBy(String senderFullName) throws StreamReadException, DatabindException, IOException {
    	//done
    	return TransactionData().stream().filter(f -> f.getSenderFullName().equalsIgnoreCase(senderFullName)).mapToDouble(t -> t.getAmount()).sum();
    }

    /**
     * Returns the highest transaction amount
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public double getMaxTransactionAmount() throws StreamReadException, DatabindException, IOException {
    	
    	//done
    	OptionalDouble a=TransactionData().stream().mapToDouble(t -> t.getAmount()).max();
    	
    	return Double.parseDouble(a.toString());
    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public long countUniqueClients() throws StreamReadException, DatabindException, IOException {
     
    	return TransactionData().stream().mapToLong(t -> t.getMtn()).distinct().count();
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public boolean hasOpenComplianceIssues(String clientFullName) throws StreamReadException, DatabindException, IOException {
    	// done
    	return TransactionData().stream().filter(t -> t.getSenderFullName().equalsIgnoreCase(clientFullName)).anyMatch(t -> t.IssueSolved());
    }

    /**
     * Returns all transactions indexed by beneficiary name
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public Map<String, Transaction> getTransactionsByBeneficiaryName() throws StreamReadException, DatabindException, IOException {
    	 Map<String, Transaction> byBeneName = TransactionData().stream().collect(Collectors.toMap(t -> t.getBeneficiaryFullName(), t -> t));
    	
    	 return byBeneName;
    }

    /**
     * Returns the identifiers of all open compliance issues
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public Set<Integer> getUnsolvedIssueIds() throws StreamReadException, DatabindException, IOException {
    	
  //  	done
       return TransactionData().stream().filter(f -> f.IssueSolved()==false).map(t -> t.getIssueId()).collect(Collectors.toSet());
    }

    /**
     * Returns a list of all solved issue messages
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public List<String> getAllSolvedIssueMessages() throws StreamReadException, DatabindException, IOException {
    	//done
    	return TransactionData().stream().filter(f -> f.IssueSolved()==true).map(t -> t.getIssueMessage()).collect(Collectors.toList());
    }

    /**
     * Returns the 3 transactions with the highest amount sorted by amount descending
     * @throws IOException 
     * @throws DatabindException 
     * @throws StreamReadException 
     */
    public List<Transaction> getTop3TransactionsByAmount() throws StreamReadException, DatabindException, IOException {
    	
    	
    	Comparator<Transaction> comparator = Comparator.comparing(Transaction::getAmount);
	     Collections.sort(TransactionData(), comparator.reversed());
	     return TransactionData().subList(0, 3).stream().collect(Collectors.toList());
	      
    }

    /**
     * Returns the senderFullName of the sender with the most total sent amount
     */
    public Optional<String> getTopSender() {
        throw new UnsupportedOperationException();
    }

}
