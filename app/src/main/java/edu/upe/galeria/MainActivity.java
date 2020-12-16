package edu.upe.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> mImageIds=new ArrayList<>(Arrays.asList(
    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,R.drawable.c6,
            R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,R.drawable.c11,R.drawable.c12
    ));
    ArrayList<String> mDescription=new ArrayList<>(Arrays.asList(
            "General 5185x3457 Neuschwanstein Castle Germany castle","Anime 2560x1440 Castle in the Sky anime castle",
            "General 1920x1080 Karlštejn Castle castle Gothic Czech Republic","General 4928x3046 castle Neuschwanstein Castle building Germany",
            "General 1920x1080 castle tower sepia low-angle Corvin Castle","General 2560x1707 castle building park Scotland Dunrobin Castle",
            "General 1920x1200 castle Romania","General 1920x1200 castle Desktopography","General 1920x1080 Neuschwanstein Castle Schloss Neuschwanstein castle Germany",
            "General 2048x1365 castle Germany moritzburg castle","General 2048x1361 castle landscape Eltz Castle","General 1920x1272 castle Poland ruins"
    ));
    GridView grdMuestra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grdMuestra=findViewById(R.id.mygrid);
        grdMuestra.setAdapter(new adaptorImagen(mImageIds,this));
        grdMuestra.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos=mImageIds.get(position);
                String text_pos=mDescription.get(position);
                showDialogo(item_pos,text_pos);

            }
        });
    }

    private void showDialogo(final int item_position,final String text_pos) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogoupe);
        TextView image_name=dialog.findViewById(R.id.txtImageName);
        ImageView imageView=dialog.findViewById(R.id.imgprevia);
        Button btnfull=dialog.findViewById(R.id.btnFull);
        Button btnclose=dialog.findViewById(R.id.btnClose);

        ImageView imagfull=findViewById(R.id.imgfull);

        String title=getResources().getResourceName(item_position);

        int index=title.indexOf("/");
        String name=title.substring(index+1,title.length());
        image_name.setText(name);

        imageView.setImageResource(item_position);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnfull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,vistaCompleta.class);
                intent.putExtra("img_id",item_position);
                intent.putExtra("descripion",text_pos);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}