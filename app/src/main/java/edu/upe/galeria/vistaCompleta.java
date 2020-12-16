package edu.upe.galeria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class vistaCompleta extends AppCompatActivity {
    ImageView imageView;
    TextView describirC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_completa);
        imageView=findViewById(R.id.imgfull);
        describirC=findViewById(R.id.descripcion);
        int img_id=getIntent().getExtras().getInt("img_id");
        String descripion=getIntent().getExtras().getString("descripion");
        imageView.setImageResource(img_id);
        describirC.setText(descripion);
    }
}