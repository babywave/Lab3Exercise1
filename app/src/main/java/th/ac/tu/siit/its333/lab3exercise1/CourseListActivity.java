package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class CourseListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_list);

        int input;
        Intent i = this.getIntent();


        ArrayList<String> course = i.getStringArrayListExtra("listcode");
        ArrayList<String> grade = i.getStringArrayListExtra("listgrade");
        ArrayList<Integer> credit = i.getIntegerArrayListExtra("listcredit");
        String s = "";
        for(int num = 0;num<course.size();num++)
        {

            s+= "\n" + course.get(num) +"("+credit.get(num)+" credits)="+grade.get(num);

        }

        TextView tv = (TextView)findViewById(R.id.tvList);
        tv.setText(s);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course_list, menu);
        return true;
    }


    public void retClicked(View v) {


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
