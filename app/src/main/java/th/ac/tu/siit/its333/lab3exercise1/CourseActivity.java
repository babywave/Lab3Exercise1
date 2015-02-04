package th.ac.tu.siit.its333.lab3exercise1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class CourseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    public void retClicked(View v) {
        Intent res = new Intent();
        EditText etcode = (EditText)findViewById(R.id.etCode);
        EditText etcr = (EditText)findViewById(R.id.etCR);

        RadioGroup pp = (RadioGroup) findViewById(R.id.radio);
        RadioButton etgr = (RadioButton)findViewById(pp.getCheckedRadioButtonId());
        res.putExtra("code", etcode.getText().toString());
        res.putExtra("credit", Integer.parseInt(etcr.getText().toString()));
        res.putExtra("grade", etgr.getText().toString());
        setResult(RESULT_OK, res);
        finish();
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
