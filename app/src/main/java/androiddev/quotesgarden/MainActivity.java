package androiddev.quotesgarden;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    String[] Quotes = {"I hear and I forget, I see and I remember. I do and I understand.",
            "Wherever you go, go with all your heart.", "Everything you can imagine is real.",
    "The Way that can be walked is not the eternal Way.","The Way is empty, yet inexhaustible, like an abyss!"
    ,"Obscure, like muddy waters.","The Way is eternal. Until your last day, you are free from peril.",
    "I do not know its name. I call it the Way. For the lack of better words I call it great.",
            "The Way is ever nameless.",
            "The great Way is all-pervading. It reaches to the left and to the right. All things depend on it with their existence. Still it demands no obedience.",
    "Words spoken about the Way have no taste. When looked at, there’s not enough to see. When listened to, there’s not enough to hear. When used, it is never exhausted.",
            "Returning is the movement of the Way.","The light of the Way seems dim.",
            "The progress of the Way seems retreating.","The straightness of the Way seems curved.",
    "The Way is hidden and nameless. Still only the Way nourishes and completes.",
            "Heaven’s net is very vast. It is sparsely meshed, yet nothing slips through.",
    "The nameless is the beginning of Heaven and Earth. The named is the mother of all things.",
    "There was something that finished chaos, born before Heaven and Earth.",
    "All things in the world are born out of being. Being is born out of non-being.",
    "Can you make your soul embrace the One and not lose it?",
            "Hold on to the ancient Way to master the present, and to learn the distant beginning.",
    "Knowledge of the eternal is all-embracing. To be all-embracing leads to righteousness, which is majestic.",
    "I alone am different from the others, because I am nourished by the great mother.",
            "The greatest virtue is to follow the Way utterly.",
            "The sage embraces the one, and is an example to the world.",
    "If I have just an ounce of sense, I follow the great Way, and fear only to stray from it.",
    "Profound virtue is indeed deep and wide. It leads all things back to the great order.",
    "When the great Tao is abandoned, benevolence and righteousness arise.",
    "Things exalted then decay. This is going against the Way. What goes against the Way meets an early end.",
    "The great Way is very straight, but people prefer to deviate.",
    "When wisdom and knowledge appear, great pretense arises.",
    "Those who understand others are clever, those who understand themselves are wise.",
    "The more clever and cunning people are, the stranger the events will be.",
    "People are difficult to rule, because of their knowledge.",
            "Not knowing of the eternal leads to unfortunate errors.",
            "Those who know it do not speak about it. Those who speak about it do not know it."};
    private TextView quoteView;
    ImageButton left,right;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteView = (TextView) findViewById(R.id.tvQuote);
        left = (ImageButton)findViewById(R.id.ibLeft);
        right = (ImageButton)findViewById(R.id.ibRight);
        quoteView.setText(Quotes[position]);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position!=0){
                    position--;
                    quoteView.setText(Quotes[position]);
                    right.setVisibility(View.VISIBLE);
                }
                else{
                    Toast.makeText(getApplicationContext(),"First Quote ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position<Quotes.length-1){
                    position++;
                    quoteView.setText(Quotes[position]);

                }
                else if((position+1) == Quotes.length){
                    right.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(),"Last Quote",Toast.LENGTH_SHORT).show();
                }
                }
        });
    }

    }

