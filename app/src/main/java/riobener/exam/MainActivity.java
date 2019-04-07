package riobener.exam;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button frChanger;
    int fragNumber = 1;// 1stFragment = 1, second-fragment = 2
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final FragmentManager fragManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragManager.beginTransaction();

        final Fragment fragment = new Fragment();
        final SecondFragment secondFragment = new SecondFragment();
        transaction.add(R.id.container,fragment).commit();

        frChanger = findViewById(R.id.frChanger);
        frChanger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (fragNumber){
                    case 1:

                        fragManager.beginTransaction().replace(R.id.container,secondFragment).commit();
                        fragNumber = 2;
                        break;
                    case 2:
                        fragManager.beginTransaction().replace(R.id.container,fragment).commit();
                        fragNumber = 1;
                        break;
                }
            }
        });
    }
}
