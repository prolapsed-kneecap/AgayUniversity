package com.polich.kneecap.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

class WebFragment : Fragment() {
    lateinit var url: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val key = requireArguments().getString("key")
        if (key != null) {
            url = requireArguments().getString(key, "file:///android_asset/technic.html")
        }
        return WebView(requireContext()).apply { loadUrl(this@WebFragment.url) }
    }
}
