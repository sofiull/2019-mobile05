package polinema.ac.id.starterchapter05.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import polinema.ac.id.starterchapter05.R;
import polinema.ac.id.starterchapter05.fragments.BlueFragment;
import polinema.ac.id.starterchapter05.fragments.RedFragment;

public class DynamicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
    }

    public void handlerClickLoadRedFragment(View view) {
        //   Todo: Mengecek apakah sudah terload atau belum
        //         Jika sudah maka tidak perlu diload kembali

        Fragment fragment = getSupportFragmentManager().findFragmentByTag("RED_FRAGMENT");
        if(fragment == null || checkCurrent().equals("BlueFragment")){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_from_left, R.anim.enter_from_left, R.anim.exit_from_right);
            fragmentTransaction.replace(R.id.frameout, new RedFragment(), "RED_FRAGMENT");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this, "Blue Fragment Telah Dimuat Sebelumnya", Toast.LENGTH_SHORT).show();
        }
    }

    public void handlerClickLoadBlueFragment(View view) {
        //   Todo: Mengecek apakah sudah terload atau belum
        //         Jika sudah maka tidak perlu diload kembali

        Fragment fragment = getSupportFragmentManager().findFragmentByTag("BLUE_FRAGMENT");
        if (fragment == null || checkCurrent().equals("RedFragment")) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            fragmentTransaction.replace(R.id.frameout, new BlueFragment(), "BLUE_FRAGMENT");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }else{
            Toast.makeText(this, "Blue Fragment Telah Dimuat Sebelumnya", Toast.LENGTH_SHORT).show();
        }
    }

    public String checkCurrent(){
        return getSupportFragmentManager().findFragmentById(R.id.frameout).getClass().getSimpleName();
    }
}

