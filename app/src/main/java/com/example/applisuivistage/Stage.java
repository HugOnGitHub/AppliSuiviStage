package com.example.applisuivistage;

public class Stage {

    protected int _idTuteurStage;
    protected int _idProfesseurStage;
    protected int _idEtudiantStage;
    protected int _idEntrepriseStage;

    public Stage(int _idtuteurStage, int _idprofesseurStage, int _idetudiantStage, int _identrepriseStage) {
        _idTuteurStage = _idtuteurStage;
        _idProfesseurStage = _idprofesseurStage;
        _idEtudiantStage = _idetudiantStage;
        _idEntrepriseStage = _identrepriseStage;
    }

    public int get_idTuteurStage() {
        return _idTuteurStage;
    }

    public int get_idProfesseurStage() {
        return _idProfesseurStage;
    }

    public int get_idEtudiantStage() {
        return _idEtudiantStage;
    }

    public int get_idEntrepriseStage() {
        return _idEntrepriseStage;
    }

    public void set_idTuteurStage(int _idtuteurStage) { _idTuteurStage = _idtuteurStage; }

    public void set_idProfesseurStage(int _idprofesseurStage) { _idProfesseurStage = _idprofesseurStage; }

    public void set_idEtudiantStage(int _idetudiantStage) { _idEtudiantStage = _idetudiantStage; }

    public void set_idEntrepriseStage(int _identrepriseStage) { _idEntrepriseStage = _identrepriseStage; }
}
