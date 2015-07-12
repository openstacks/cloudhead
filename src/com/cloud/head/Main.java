package com.cloud.head;

/* Copyright 2010-2016 Yuxingw
   All Rights Reserved.
        #
        #    Licensed under the Apache License, Version 2.0 (the "License"); you may
        #    not use this file except in compliance with the License. You may obtain
        #    a copy of the License at
        #
        #         http://www.apache.org/licenses/LICENSE-2.0
        #
        #    Unless required by applicable law or agreed to in writing, software
        #    distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
        #    WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
        #    License for the specific language governing permissions and limitations
        #    under the License.
*/


import com.cloud.head.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class Main extends Activity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);
        webView = (WebView)findViewById(R.id.fullscreen_content);
        webView.setWebViewClient(new CloudWebViewClient());
        webView.loadUrl("file:///android_asset/www/index.html");
        //you can also link to a website. Example:
        //webView.loadUrl("www.google.com");
        //I have included web permissions in the AndroidManifest.xml
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDatabasePath("/data/data/"+this.getPackageName()+"/databases/");
        
    }
    
    @Override
    public void onBackPressed()
    {
        if(webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }
    

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    
}
