package ma.projet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ma.projet.interfaces.filiere.FiliereList;
import ma.projet.interfaces.role.RoleList;
import ma.projet.interfaces.student.StudentList;

public class MainActivity extends AppCompatActivity {

    private Button studentBtn, filiereBtn, roleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        toolbar.setTitle("Gestion des étudiants");
        setSupportActionBar(toolbar);


        studentBtn = findViewById(R.id.idStudentBtn);
        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StudentList.class);
                startActivity(intent);
            }
        });
        filiereBtn = findViewById(R.id.idFiliereBtn);
        filiereBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FiliereList.class);
                startActivity(intent);
            }
        });
        roleBtn = findViewById(R.id.idRoleBtn);
        roleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RoleList.class);
                startActivity(intent);
            }
        });


    }
}