/* Copyright 2015 Skubit
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.skubit.satoshidice.services;

import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;
import retrofit.converter.JacksonConverter;
import android.content.Context;

import com.skubit.satoshidice.Constants;
import com.squareup.okhttp.OkHttpClient;

public abstract class BaseService<T> {

	private T mRestService;

	public BaseService(Context context) {
		final RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint(Constants.SATOSHI_DICE)
				.setConverter(new JacksonConverter()).build();
		if (Constants.LOG_LEVEL_FULL) {
			restAdapter.setLogLevel(LogLevel.FULL);
		}
		mRestService = restAdapter.create(getClazz());
	}

	public abstract Class<T> getClazz();

	public T getRestService() {
		return mRestService;
	}
	
	private static OkHttpClient getUnsafeOkHttpClient() {
		  try {
		    // Create a trust manager that does not validate certificate chains
		    final TrustManager[] trustAllCerts = new TrustManager[] {
		        new X509TrustManager() {
		          @Override
		          public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
		          }

		          @Override
		          public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
		          }

		          @Override
		          public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		            return null;
		          }
		        }
		    };

		    // Install the all-trusting trust manager
		    final SSLContext sslContext = SSLContext.getInstance("SSL");
		    sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
		    // Create an ssl socket factory with our all-trusting manager
		    final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

		    OkHttpClient okHttpClient = new OkHttpClient();
		    okHttpClient.setSslSocketFactory(sslSocketFactory);
		    okHttpClient.setHostnameVerifier(new HostnameVerifier() {
		      @Override
		      public boolean verify(String hostname, SSLSession session) {
		        return true;
		      }

		    });

		    return okHttpClient;
		  } catch (Exception e) {
		    throw new RuntimeException(e);
		  }
		}
}
