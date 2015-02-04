package th.ac.tu.siit.its333.lab3exercise1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;


public class MainActivity extends ActionBarActivity {

    int cr = 0;         // Credits
    double gp = 0.0;    // Grade points
    double gpa = 0.0;   // Grade point average

    ArrayList<String> listCodes;
    ArrayList<Integer> listCredits;
    ArrayList<String> listGrades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCodes = new ArrayList<String>();
        listCredits = new ArrayList<Integer>();
        listGrades = new ArrayList<String>();
        //Use listCodes.add("ITS333"); to add a new course code
        //Use listCodes.size() to refer to the number of courses in the list
    }


    public void calculate() {
        cr = 0;
        gp = 0.0;
        gpa = 0.0;

        TextView tvgp = (TextView)findViewById(R.id.tvGP);
        TextView tvgpa = (TextView)findViewById(R.id.tvGPA);
        TextView tvcr = (TextView)findViewById(R.id.tvCR);

        for(int loop = 0;loop<listGrades.size();loop++)
        {

            cr += listCredits.get(loop);
            gp += (listCredits.get(loop) * grade(listGrades.get(loop)));
            Log.d("Test", listCredits.get(loop) + "");
            Log.d("Test", gp + "");

        }

        gpa = gp/cr;
        if(cr==0)
        {
            gpa = 0;

        }
        tvgp.setText(String.valueOf(gp));
        tvgpa.setText(gpa+"");
        tvcr.setText(cr+"");

    }

    public double grade(String x)
    {
        switch (x){
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D+":
                return 1.5;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
        }
        return 0.0;

    }


    public void buttonClicked(View v) {
        int id = v.getId();
        Intent ac1 = new Intent(this, CourseActivity.class);
        Intent ac2 = new Intent(this, CourseListActivity.class);

        switch (id){

            case R.id.button2:
                startActivityForResult(ac1,88);
                break;
            case R.id.button4:
                ac2.putStringArrayListExtra("listcode",listCodes);
                ac2.putIntegerArrayListExtra("listcredit", listCredits);
                ac2.putStringArrayListExtra("listgrade", listGrades);
                ac2.putExtra("loop",listCodes.size());
                startActivityForResult(ac2, 89);
                break;
            case R.id.button:
                listGrades.clear();
                listCodes.clear();
                listCredits.clear();
                calculate();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        TextView tvgp = (TextView)findViewById(R.id.tvGP);
        TextView tvcr = (TextView)findViewById(R.id.tvCR);
        TextView tvgpa = (TextView)findViewById(R.id.tvGPA);

        if (requestCode == 88) {
            if (resultCode == RESULT_OK) {
                String resultcode = data.getStringExtra("code");
                Integer resultcr = data.getIntExtra("credit",0);
                String resultgp = data.getStringExtra("grade");
                Log.d("Test","request 88");

                listCodes.add(resultcode);
                listGrades.add(resultgp);
                listCredits.add(resultcr);
                calculate();
            }
            else if (resultCode == RESULT_CANCELED) {
            }
        }

        if (requestCode == 89) {


        }
        // Values from child activity
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
