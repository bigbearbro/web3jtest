package org.jhblockchain.web3jtest;

import org.junit.Test;

import rx.Subscription;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 * Unit test for simple App.
 */
public class TxObservableTest extends BaseTest {

	@Test
	public void testApp() {
		Subscription subscription = web3j.transactionObservable().subscribe(tx -> {
			System.out.println(JSON.toJSONString(tx, SerializerFeature.PrettyFormat));
		});
		pending();
	}
}
