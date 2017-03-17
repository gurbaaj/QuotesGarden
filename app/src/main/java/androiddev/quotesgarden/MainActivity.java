package androiddev.quotesgarden;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{

    private TextView quoteView,nameView;
    ImageButton left, right;
    int position = 0;
    GestureDetector gestureDetector;
    List<String> quotes,names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteView = (TextView) findViewById(R.id.tvQuote);
        nameView = (TextView)findViewById(R.id.comedianName);
        left = (ImageButton) findViewById(R.id.ibLeft);
        right = (ImageButton) findViewById(R.id.ibRight);
        quotes = new ArrayList<>();
        names = new ArrayList<>();
        gestureDetector = new GestureDetector(MainActivity.this,MainActivity.this);
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        quotes = databaseAccess.getQuotes();
        names = databaseAccess.getNames();
        databaseAccess.close();
        Typeface customFont = Typeface.createFromAsset(getAssets(),"fonts/lato.ttf");
        quoteView.setTypeface(customFont);
        quoteView.setText(quotes.get(position));
        nameView.setText(names.get(position));

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position != 0) {
                    position--;
                    quoteView.setText(quotes.get(position));
                    nameView.setText(names.get(position));
                    right.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "First Quote ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position < quotes.size() - 1) {
                    position++;
                    quoteView.setText(quotes.get(position));
                    nameView.setText(names.get(position));
                } else if ((position + 1) == quotes.size()) {
                    right.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "Last Quote", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {       return true;    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {
        if(motionEvent1.getX() - motionEvent2.getX() > 50){

            if (position < quotes.size() - 1) {
                position++;
                quoteView.setText(quotes.get(position));
                nameView.setText(names.get(position));
            } else if ((position + 1) == quotes.size()) {
                right.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Last Quote", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
        if(motionEvent2.getX() - motionEvent1.getX() > 50) {

            if (position != 0) {
                position--;
                quoteView.setText(quotes.get(position ));
                nameView.setText(names.get(position));
                right.setVisibility(View.VISIBLE);
            } else {
                Toast.makeText(getApplicationContext(), "First Quote ", Toast.LENGTH_SHORT).show();
            }

            return true;
        }
        else{
            return true;
        }


    }
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        // TODO Auto-generated method stub

        return gestureDetector.onTouchEvent(motionEvent);
    }

}

