package br.ifsc.edu.notas;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Notas {
    SharedPreferences preferencias;
    SharedPreferences.Editor editorPreferencias;
    Context contexto;
    private static final String PREFERENCIAS_FILE = "Notas";

    public Notas(Context c) {
        this.contexto = c;
        preferencias =this.contexto.getSharedPreferences(PREFERENCIAS_FILE, Context.MODE_PRIVATE);
        editorPreferencias=preferencias.edit();
    }

    public String recuperaNota(){
        if (this.preferencias.contains("nota")){
            String s=contexto.getResources().getString(R.string.nota_recuperada);
            Toast.makeText(this.contexto, s,Toast.LENGTH_LONG).show();
            return this.preferencias.getString("nota","");
        }else{
            return "";
        }
    }

    public void salvaNota(String s){
        if (s.trim().equals("")){
            Toast.makeText(this.contexto, contexto.getResources().getString(R.string.nota_vazia),Toast.LENGTH_LONG).show();
        }else{
            this.editorPreferencias.putString("nota",s);
            this.editorPreferencias.commit();
            Toast.makeText(this.contexto, contexto.getResources().getString(R.string.nota_salva),Toast.LENGTH_LONG).show();
        }
    }
}
