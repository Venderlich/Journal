package journal.Filiere.Service;

public class Filiere {
    Integer Id;
    String Label;
    String Matiere;



    public Integer getID()  {
        return Id;
    }

    public String getLabel(){
        return Label;
    }

    public String getMatiere(){
        return Matiere;
    }

    public void setId(Integer pId)
    {
        Id = pId;
    }

    public void setLabel(String pLabel)
    {
        Label = pLabel;
    }

    public void setMatiere(String pMatiere)
    {
        Matiere = pMatiere;
    }

}