package de.apoth.alaia_android;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class TrackListActivity extends Activity {

    private EditText myUrlEntry = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);

        ImageButton callButton = (ImageButton) this.findViewById(R.id.callButton);
        ImageButton cancelButton = (ImageButton) this.findViewById(R.id.cancelButton);
        this.myUrlEntry = (EditText) this.findViewById(R.id.urlEntry);
        myUrlEntry.setSingleLine();

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myUrlEntry == null)
                    return;
                myUrlEntry.setText("");
            }
        });
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onUrlCalled();
            }
        });

        this.myUrlEntry.setImeActionLabel("Visit", KeyEvent.KEYCODE_ENTER);
        myUrlEntry.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //if(event.getKeyCode() == KeyEvent.KEYCODE_ENTER)
                //doesnt work because event seems to be null
                if(actionId == EditorInfo.IME_NULL)
                {
                    onUrlCalled();
                }
                return false;
            }

        });
    }

    public void onUrlCalled()
    {
        if(this.myUrlEntry == null)
            return;
        String url = this.myUrlEntry.getText().toString();


        //url = "https://www.google.de";
        Uri uri = Uri.parse(url);
        Intent pageIntent = new Intent(TrackListActivity.this,WebActivity.class);

        pageIntent.setData(uri);
        //pageIntent.putExtra("de.apoth.alaia_android.url",url);
        TrackListActivity.this.startActivity(pageIntent);
        this.myUrlEntry.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_track_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
