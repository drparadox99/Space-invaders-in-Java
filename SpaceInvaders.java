import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SpaceInvaders{
/*
public static void AlienX(int x,int y,InterfaceSpaceInvaders toto)
{
  int tabx [] = {3,8,4,7,3,4,5,6,7,8,2,3,5,6,8,9,1,2,3,4,5,6,7,8,9,10,1,3,4,5,6,7,8,10,1,3,8,10,4,7};       //Coordonnés x et y d'un alien
  int taby[]  ={1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,7,7,7,7,8,8,};

  for (int i=0;i<40;i=i+1)
  {
    toto.modifieCase(tabx[i]+x,taby[i]+y,Color.RED);
  }
}
*/

static class NewAliens1                                                                    //l'enregistrement comportant ds tableaux avec des coordonnées x,y d'un alien
 {
    int tabx [] = {3,8,4,7,3,4,5,6,7,8,2,3,5,6,8,9,1,2,3,4,5,6,7,8,9,10,1,3,4,5,6,7,8,10,1,3,8,10,4,7};
    int taby [] = {1,1,2,2,3,3,3,3,3,3,4,4,4,4,4,4,5,5,5,5,5,5,5,5,5,5,6,6,6,6,6,6,6,6,7,7,7,7,8,8};
    int color ;
 }	

public static void Tria1(InterfaceSpaceInvaders toto, NewAliens1 AlienE)         
{                                                                           // fonction qui va colorer les coordonnées des tableaux de l'enregistrement de l'alien en fonction de la variable couleur de l'enregistrement
  if(AlienE.color == 0) 
  {
    for (int i=0;i<40;i=i+1)
    {
      toto.modifieCase(AlienE.tabx[i],AlienE.taby[i],Color.BLACK);
    }
  }

  if (AlienE.color == 1)
  {     
    for (int i=0;i<40;i=i+1)
    {
      toto.modifieCase(AlienE.tabx[i],AlienE.taby[i],Color.GREEN);
    }         
  }
}

public static void Trias(InterfaceSpaceInvaders toto, NewAliens1 AlienE)                
{                                                                                //fonction qui va colorer les coordonnées des tableaux de l'enregistrement d
  for (int i=0;i<40;i=i+1)
  {     
    toto.modifieCase(AlienE.tabx[i],AlienE.taby[i],Color.BLACK);
  }
}

static class Cl_Tirs
{                                                                               //l'enregistement du tirs , comportant un tableau x et un tableau y representant les coordonnées du trs
  int tabx [] = {5,5,5,5,5,6,6,6,6,6};
  int taby[]  ={195,196,197,198,199,195,196,197,198,199};
}

public static void Tirs(int x,int y,InterfaceSpaceInvaders toto, Cl_Tirs tirs)
{
  for (int i=0;i<10;i=i+1)
  {
    toto.modifieCase(tirs.tabx[i]+x,tirs.taby[i]+y,Color.YELLOW);
  }
}
    
public static void TirsM(int x,int y,InterfaceSpaceInvaders toto, Cl_Tirs tirs) 
{                                                                                //fonction qui va colorer les coordonnées de l'enregistrement du tirs
  for (int i=0;i<10;i=i+1)
  {
    toto.modifieCase(tirs.tabx[i]+x,tirs.taby[i]+y,Color.BLACK);
  }
}
  

static class Cl_Canon                                 
{                                                                               //l'enregistrement du canon comportant 
  int tabx[] = {4,5,4,5,2,3,4,5,6,7,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};               //tableau comportant les coordonnées des aliuens sur l'axe x
  int taby[] = {0,0,1,1,2,2,2,2,2,2,3,3,3,3,3,3,3,3,4,4,4,4,4,4,4,4};             //tableau comportant les coordonnées des alaiens sur l'axe y
  int fixtabx []= new int [26];                                                   //tableaux compotant aussi les coordonnés des aliens sur l'axe x
  int fixtaby []= new int [26];                                                 //tableau comportant aussi les coordonnées des alliens sur l'axe y
  int color ;                                                                   //variable couleur qui détermine la couleur de l'alien(0 ou 1)
  int vies = 3;                                                                    //variable contenant les tois vies du joueur
}  

public static void Canon(InterfaceSpaceInvaders toto,int x,int y,Cl_Canon vaisseau)
{                                                               //fonction qui fait appataitre les aliens en coloriant les coordonners des tableaux de l'enregistrement du tirs en fonction de la valeur de variable couleur
  if(vaisseau.color==1)
  {
     for (int i=0; i<26; i++)
     {
      toto.modifieCase(vaisseau.tabx[i]+x,vaisseau.taby[i]+y,Color.RED);
     }
  }
  
  if(vaisseau.color==0)
  { 
      for (int i=0; i<26; i++)
      {
          toto.modifieCase(vaisseau.tabx[i]+x,vaisseau.taby[i]+y,Color.BLACK);
      } 
  }
  if(vaisseau.color==2)
  { 
      for (int i=0; i<26; i++)
      {
          toto.modifieCase(vaisseau.tabx[i]+x,vaisseau.taby[i]+y,Color.CYAN);
      } 
  }

}

public static void CanonM(InterfaceSpaceInvaders toto,int x,int y,Cl_Canon vaisseau) 
{                                                                                    //fonction qui fai disparaitre les aliens en changeant leur couleurs en noir
   for (int i=0; i<26; i++)
   {
      toto.modifieCase(vaisseau.tabx[i]+x,vaisseau.taby[i]+y,Color.BLACK);
   }   
}

static class AlienTirs
{                                                                       //l'enregistement des tirs venant des aliens 
  int tabx [] = {5,5,5,5,5,6,6,6,6,6};                                //tableau compatant les coordonnés du tirs sur l'axe x
  int taby [] = new int[10];                                         //tableau déstiné pour les coordonnés du tirs sur l'axe y
}

public static void TirsAlien(int x, int y, InterfaceSpaceInvaders toto, AlienTirs tirs, Color c)          
{                                                                                 //fonction qui fait apparaitre ou disparaitre tirs en fonction de la couleur du paramètre
  for(int i=0;i<10;i=i+1)
  {
    toto.modifieCase(tirs.tabx[i]+x,tirs.taby[i]+y,c);
  }
}

public static void main(String [] args)
{
InterfaceSpaceInvaders toto = new InterfaceSpaceInvaders(300,200,Color.BLACK) ;       //creation d'un object pour l'interfaceSpaceInvaders
NewAliens1 minions [] = new NewAliens1 [60];                                           //creation du tableau d'enregistrement pour les aliens
Cl_Canon vaisseau = new Cl_Canon();                                                    //création d'un object pour la classe canon
Cl_Canon vie = new Cl_Canon();                                                         //creation d'un deuxième object de la classe canon représentant les vies du joueur

boolean [] state = new boolean[1];
state [0] = true;
vaisseau.color=1;
int xx,yy;
yy= 195;
int nbdemort=0 ;


      vie.color=2;                                 //désignation de la couleur de trois vaisseaux représentant les vies du joueur
      Canon(toto,290,10,vie);                    //creation de trois vaisseaux représentant les vies du joueur
      Canon(toto,290,20,vie);
      Canon(toto,290,30,vie);




while(state[0])
{

Thread obj2 = new Thread ()                        //utiisation d'un thread qui fait jouer de la musique
 { 
    public void run()
    {

    class AddSound extends JFrame
 {
  JButton Play = new JButton("Play");           //création d'un button play
  JButton Loop = new JButton ("Loop");          //création d'un button loop, jouer en boucle
  JButton Stop = new JButton ("Stop");           //création d'un button stop

  // URL url = AddSound.class.getResource("Coldplay.wav");    //insertion du fichier audio
  // AudioClip clip = Applet.newAudioClip(url);                //AudioClip est une classe qui contient la fonction play,loop et clip
                                                             //création object Audioclip en utilisant Applet.newAudioClip
                                                             //Applet est une classe

  Clip clip;

   public AddSound() { // constructeur du programme
        super("AddingSound"); // titre du programme
        setLayout(new FlowLayout()); // utilisation de la fenêtre JFrame

        try {
            // Load the audio file
            File audioFile = new File("Coldplay.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Get a sound clip resource
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

        Play.addActionListener(new ActionListener() { // fait en sorte que le boutton play crée va commencer la musique
            public void actionPerformed(ActionEvent event) { // la musique commence dès qu'on appuie sur le button play
                clip.setFramePosition(0); // reset to the beginning
                clip.start(); // fonction qui joue une fois la musique
            }
        });

        Loop.addActionListener(new ActionListener() { // fait en sorte que le boutton loop crée va commencer à jouer la musique en boucle
            public void actionPerformed(ActionEvent event) { // la musique commence à jouer en boucle dès qu'on appuie sur le button loop
                clip.loop(Clip.LOOP_CONTINUOUSLY); // fonction qui joue la musique en boucle
            }
        });

        Stop.addActionListener(new ActionListener() { // fait en sorte que le boutton stop crée va stopper la musique
            public void actionPerformed(ActionEvent event) { // arrête la musique dès qu'on appuie sur le button stop
                clip.stop(); // fonction qui arrête la musique
            }
        });

        add(Play); // on ajoute le bouton play dans la fenêtre JFrame
        add(Loop); // on ajoute le bouton loop dans la fenêtre JFrame
        add(Stop); // on ajoute le bouton stop dans la fenêtre JFrame
    }

}
   JFrame frame = new AddSound(); 
  //  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //on arrete la musique dès qu'on ferme ta fenêtre
  //  frame.setSize(90,90);                                     //on définit la taille de la fenêtre
  //  frame.setVisible(true);                                  //on définit la visibilité de la fenêtre

   }
 };
 obj2.start();                                     //fonction qui lance tout ce qui se trouve dans le thread

Thread obj1 = new Thread ()                          //utilisation d'un deuxième thread qui lance l'algo permettant de creer les aliens et de les deplacer
 { 
    public void run()
    {
      int k;
      k = 0;
      int q;
      int x,y;
      x=1;
      y=0;
      int maxalea=60, minalea=50;
      int cptalea=0;

      for (int j=0;j<60;j=j+1)                                            //Creation d'un tableau de 60 enregistrement, c'à-dire 60 aliens
      {
       minions[j] = new NewAliens1(); 
       minions[j].color=1;                                                      //on attribue la couleur blanc aux aliens dès leur création      
      }
     for (int j=0;j<10;j=j+1)                                                //j pour numeroter les cases du tableau de l'enrestrement (aliens) 
     {
        for(int i=0;i<=minions[j].tabx.length-1;i=i+1)             
        {
          q=0;
          for (int b=0;b<=50;b=b+10)
          {                                                                       //b va incrementer certains les j de l'enregistrement 
            minions[j+b].tabx[i]=minions[j+b].tabx[i]+k+x;                       //pour creer ls aliens il va incrementer k=15 sur chaque x de tabx 
            minions[j+b].taby[i]=minions[j+b].taby[i]+q+y;                       //il va descendre de q=15 pour contibuer à additionner les x du tabx
            q=q+15;                                                            //fait descendre sur y pour creer des aliens de ce rang    
          }
        }
        k=k+15;
      }

     for(int a=30;a<=250;a=a+10)                                                 // encadre les aliens
     {                                                                              //fonction qui déplace les aliens vers la droite,gauche et les fait déscendre
       try{        
            for (int j=0;j<minions.length;j=j+1)
            {
              for (int i=0;i<minions[j].tabx.length;i=i+1)
              { 
                if (a==250)                                                    //on verifie si les aliens se trouvent à l'extremité gauche de l'ecran
                {                                                              //si c'est le cas on les fait descendre sur l'axe y de 5
               minions[j].taby[i]=minions[j].taby[i]+5; 

                    for(int h=0;h<60;h=h+1)                                      //on vérfie si au moins un alien arrive jusqu'au niveau du canon
                    {
                      if (minions[h].color==1)                                     // si c'est le cas, on arrete le jeux et le joueur vient de perdre
                      {
                        if(minions[h].taby[39]>=195)
                        {
                          toto.afficheMessage("GAME OVER VOUS AVEZ ETE ENVAHI"); //affichange d'un message  si le joueur perd 
                           try{Thread.sleep(99999999);}
                           catch(InterruptedException e){}
                        }
                      }

                    }
                }
                else
                {
                minions[j].tabx[i]=minions[j].tabx[i]+6*x;             // on fait avancer les aliens sur l'axe x
                }  
              } 
              Tria1(toto,minions[j]);                                         
            } 
            Thread.sleep(600);                                       //un sleep qui détermine la vitesse du déplacement des aliens
          }
          catch(InterruptedException e){}


       int alea1;                                                           //Permet aux aliens de tirer aléatoirement si alea1 = 5 ou alea=1 grâce à la fonction Tir
       alea1=(int)(Math.random()*(10-0)+0);                               //Apellation de la fonction Tir qui fait en sorte que les Aliens tirent au hasard
       if(alea1==5 || alea1== 1 )                                         //en réaliste  on détermine la fréquence des tirs
       {
           int alea2;
           AlienTirs tirs = new AlienTirs();
           alea2=(int)(Math.random()*(maxalea-minalea)+minalea); 
           for(int f=minalea; f<maxalea; f=f+1)                        //on vérifie si tous les aliens du rang du tis sont à 0, si c'est le cas on décrement la position y du tirs de 10
           {
            if(minions[minalea].color==0 && minions[minalea+1].color==0 && minions[minalea +2].color==0 && minions[minalea+3].color==0 && minions[minalea+4].color==0 && minions[minalea+5].color==0 && minions[minalea+6].color==0 && minions[minalea+7].color==0 && minions[minalea+8].color==0 && minions[minalea +9].color==0)
            {
              maxalea=maxalea-10;
              minalea=minalea-10;
            }
          }
         if(minions[alea2].color==1)                                  //l'alien tir que s'il est en vivant, c'est-à-dire il est en blanc
         {                                                               //Sélectionne au hasard un alien parmis la dernière ligne
         tirs.taby[0] = minions[alea2].taby[39];                     //Affecte le y le plus grand du tableau de l'alien au y le plus petit du missile. Son point de départ
         int cpt = 1;
         for(int z=1;z<10;z=z+1)                                   //Permet de dessiner le missile en fonction des cooredonnées de l'alien selectionné au hasard
         {
           if(z==5)                               
           {
             tirs.taby[5]=tirs.taby[0];
             cpt=1;
           }
           if(z>5)
           {
             tirs.taby[z]=tirs.taby[0]+cpt;
             cpt=cpt+1;
           }
         }
              
         for(int w=0;w<170;w=w+2)    
        {
          try
          {
            TirsAlien(minions[alea2].tabx[0],w+5,toto,tirs,Color.GREEN);         //le tirs de l'alien prend la position X d'un minion
            if( (tirs.taby[9]+w+5>195 && tirs.taby[9]+w+5<200) && (vaisseau.fixtabx[18]-5<=minions[alea2].tabx[0]+6 && vaisseau.fixtabx[18]+15>minions[alea2].tabx[0]+6))
            {      
              if (vaisseau.color==1)
              {
                vaisseau.color=0;                                                    //on vérifie la valeur de la variable vie du canon
                TirsAlien(minions[alea2].tabx[0],w+5,toto,tirs,Color.BLACK); 
                w=120;
                vaisseau.vies=vaisseau.vies-1;

                if (vaisseau.vies==2)                                                  
                {                                               
                 toto.afficheMessage("Il vous reste 2 vies");
                  vie.color=0;                                               //c'est pour effacer une vie du joueur qui se trouve à droite de l'écran
                  Canon(toto,290,10,vie);
                }
                if (vaisseau.vies==1)
                {
                   toto.afficheMessage("Il vous reste 1 vie"); 
                   vie.color=0;
                  Canon(toto,290,20,vie);
                }
                if (vaisseau.vies==0)
                { 
                   toto.afficheMessage("Aucune vie restante Fin de la partie. ");
                   vie.color=0;
                   Canon(toto,290,30,vie);
                    state[0]=false;
                   System.out.println(state[0]);
                   
                   try{

                    Thread.sleep(99999999);
                   }
                   catch(InterruptedException e){}

                }
              }
             }    
             vaisseau.color=1; 
             Thread.sleep(30);
           }
           catch(InterruptedException e){}
           TirsAlien(minions[alea2].tabx[0],w+5,toto,tirs,Color.BLACK);      //on appelle la fonction tirs et on deplace le tirs vers le haut
         }                                                                    //
        }     
      }

        for (int j=0;j<minions.length;j=j+1)
        {                              
          Trias(toto,minions[j]);              
        }   
        
        if (a==250)                           //si les aliens arrivent à l'extemite gauche de l'ecran on commence à faire avancer les aliens vers la gauche
        {
          x=x*-1;
          a=30;
        }
    } 
  }
 };

 obj1.start();


Cl_Tirs tirs = new Cl_Tirs();                         //on crée une instance du tirs du canon
int a=2;
int t;  
int v=150;

while(a>0)                                  
{
  t=toto.toucheTapee();                                   //on stocke les valeurs des touches du joueur dans une variable
  try{Thread.sleep(5);}catch(InterruptedException e){}

  if( (t==1)&&(v>0))                                         //on verifie si la touche tapée est églae à 1, si c'est le cas, on fait avancer le canon vers la gauche
  { 
    v=v-6;
    CanonM(toto,v+6,yy,vaisseau); 
    Canon(toto,v,yy,vaisseau);
    for(int p=0;p<26;p=p+1)
    {
      vaisseau.fixtabx[p]=vaisseau.tabx[p]+v+6;                      //le tableau fixtabx contient la position x absolue des aliens après leur déplacement à gauche
      vaisseau.fixtaby[p]=vaisseau.taby[p]+yy;                       //le tableau fixtaby contient la position y absolue des aliens après leur dépalcement à gauche
    }
  }

  if(( t== 2)&&(v<280))                                             //on verifie si la touche tapée est egale à 2, si c'est le cas, on fait avancer le canon vers la droite
  { 
    v=v+6;
    CanonM(toto,v-6,yy,vaisseau); 
    Canon(toto,v,yy,vaisseau); 
    for(int p=0;p<26;p=p+1)
    {
      vaisseau.fixtabx[p]=vaisseau.tabx[p]+v-6;                    //le tableau fixtabx contient la position x absolue des aliens après leur déplacement à droite
      vaisseau.fixtaby[p]=vaisseau.taby[p]+yy;                      //le tableau fixtaby contient la position y absolue des aliens après leur dépalcement à droite
    }
   }   
          
  if (t == 0)                                   
  {                                                                    //on verifie la touche tapée est égale à 0, si c'est le cas on le canon commence à tirer
    for(int i=0;i<220;i=i+10)     
    {
      try
      {
        Tirs(v-1,-i-5,toto,tirs);                                           //on décremente le i qui fait avance le tirs vers le haut
        for(int r=0;r<60;r=r+1)
        {                                                                   //VERIFICATION DES COLLISIONS

                          for (int p=0;p<40;p=p+1)                       //on parcoure le tableuau d'enregistement des aliens 
                          {     
                           for(int z=0; z<10;z=z+1)                         //on parcoure le tableau du tirs

                           {                                                
                             if ((tirs.taby[z]-i-5 == minions[r].taby[p]) && (tirs.tabx[z]+v-1==minions[r].tabx[p]))        //on verifie s'il y a des coordonnés communs, si c'est le cas on vient de détecter une collision
                              {
                                  if (minions[r].color==1)                   //La condition vérifie si le premier alien en partant du bas de la colonne est à 1, si oui,
                                 {                                            //elle le supprime sinon elle va aller vérifier le deuxième alien en partant du plus du bas,ainsi de suite.
                                    minions[r].color=0;
                                   Tria1(toto,minions[r]);
                                  TirsM(v-1,-i-5,toto,tirs);
                                  i=220;                                             //on arrete le déplacement du tirs
                                  nbdemort = nbdemort +1;                          //à chaque fois qu'on éfface un alien, on incrément nbdemort de 1, pour savoir combien d'aliens sont morts
                                  if (nbdemort==60)                                   //si le nombre des aliens morts est égale à 60, on arrete le jeux et le joueur gagne
                                  {
                                    toto.afficheMessage("GAME OVER vous avez repoussé l'envahisseur. Score= "+ nbdemort*10);     //on attribue des points au joueur à la fin du jeu, 10 points/alien
                                    try{Thread.sleep(9999999);}
                                    catch(InterruptedException e){}
                                  }
                                 }                               
                              }

                           }
                          } 
        } 
        Thread.sleep(10);
       }
       catch(InterruptedException e){}
       TirsM(v-1,-i-5,toto,tirs);                       //on supprime les traces du tirs
     }
    }      
  }    

}
      

} 

}
