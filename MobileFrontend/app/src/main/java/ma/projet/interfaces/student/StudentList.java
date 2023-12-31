package ma.projet.interfaces.student;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import ma.projet.R;
import ma.projet.adapters.StudentAdapter;
import ma.projet.entities.Student;

public class StudentList extends AppCompatActivity {
    private List<Student> students = new ArrayList<>();
    private ListView studentsList;
    RequestQueue requestQueue;
    StudentAdapter studentAdapter ;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        studentAdapter = new StudentAdapter(students, this);
        getStuents();
        addButton = findViewById(R.id.idAddStudentBtn);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentList.this, AddStudent.class);
                startActivity(intent);
                StudentList.this.finish();
            }
        });


    }

    public void getStuents(){
        String getSUrl = "http://192.168.11.167:8080/api/student";
        requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                getSUrl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Gson gson = new Gson();
//                Log.d("students",response.toString());
                TypeToken<List<Student>> token = new TypeToken<List<Student>>() {};
                students = gson.fromJson(response.toString(), token.getType());
                studentsList = findViewById(R.id.studentList);
                Log.d("student",students.toString());
                studentAdapter.updateStudentsList(students);
                studentsList.setAdapter(studentAdapter);
                studentsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        final TextView idstudent = view.findViewById(R.id.id);
                        Intent intent = new Intent(StudentList.this, UpdateStudent.class);
                        intent.putExtra("id",idstudent.getText().toString());
                        StudentList.this.finish();
                        StudentList.this.finish();
                        startActivity(intent);
                    }
                });

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Erreur", error.toString());
            }
        });
        requestQueue.add(request);
    }

}