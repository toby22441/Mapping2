package com.example.a2durnt35.mapping;

        import android.preference.PreferenceActivity;
        import android.os.Bundle;

public class PreferencesActivity extends PreferenceActivity
{
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}


