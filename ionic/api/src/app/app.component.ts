import { Component } from '@angular/core';
import { StatusBar } from '@capacitor/status-bar';
import { Platform } from '@ionic/angular';
import { Storage } from '@ionic/storage';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {
  rootPage: any = TabsPage;

  dbExiste: any;
  constructor(platform: Platform, statusBar: StatusBar, splashScreen: SplashScreen,
    storage: Storage) {
      platform.ready().then(() => {
        storage.get("dbExists")
        .then((value)=>{
          if(value == null){
            console.log("No existe la variable");
            storage.set("dbExists", "1")
            .then(()=>{
              console.log("Variable añadida");
            })
          }else{
            console.log("Existe la variable" + value);
            this.dbExiste = value;
          }
        })
      })
    }
}
