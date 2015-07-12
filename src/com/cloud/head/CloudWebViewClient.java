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

ReadMe
1:The default behavior of Android is to open device browser, when links are clicked.
But as our WebView should work like a embedded browser,
we must override to always open the links in the WebView instead redirecting it to the default browser.

2:We can do this using android WebViewClient.
WebViewClient helps to monitor events in a WebView.
We have to override the shouldOverrideUrlLoading() method.
This method allows performing your own action when a particular URL is selected.
Once we are ready with the WebViewClient, we can set the WebViewClient of your WebView using the setWebViewClient() method.

3:The WebViewClient class has some other useful methods such as
onPageStarted(), onPageFinished() and onReceivedError()
that helps you to show loading progress of WebView content, or handle error.

*/

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class CloudWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
