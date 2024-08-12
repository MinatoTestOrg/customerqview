import { Injectable,inject } from '@angular/core';
import { Subject, Observable } from 'rxjs';
import { AppGlobalService } from '@baseapp/app-global.service';
import { environment } from '@env/environment';

@Injectable({
  providedIn: 'root'
})
export class AppHomeBaseService {

  public appGlobalService = inject(AppGlobalService);
 
  

  config : any = [ {
  "expanded" : true,
  "folder" : true,
  "data" : {
    "properties" : { }
  },
  "children" : [ {
    "expanded" : true,
    "folder" : true,
    "data" : {
      "properties" : {
        "tileType" : "type_1",
        "outline" : false,
        "label" : ""
      }
    },
    "children" : [ {
      "expanded" : false,
      "folder" : false,
      "data" : {
        "properties" : {
          "accessControl" : [ "App Admin" ],
          "onClick" : "navigate_to_page",
          "outline" : false,
          "infiniteScroll" : false,
          "data" : "homeTile1",
          "field" : "homeTile",
          "valueChange" : true,
          "currentNode" : "6449b73f-92f0-456c-b5cb-53a3c1977b31",
          "label" : "CUSTOMER",
          "page" : {
            "sid" : "42215061-498c-4631-9b1b-0592fa489f1f",
            "name" : "Customer List",
            "url" : "/customer/customerlist"
          },
          "class" : "home-tile"
        }
      },
      "title" : "Customer",
      "type" : "homeTile",
      "key" : "homeTile",
      "selected" : false
    }, {
      "expanded" : false,
      "folder" : false,
      "data" : {
        "properties" : {
          "accessControl" : [ "App Admin" ],
          "onClick" : "navigate_to_page",
          "outline" : false,
          "infiniteScroll" : false,
          "valueChange" : true,
          "currentNode" : "50667634-b478-4f19-b84d-59fe6277672b",
          "label" : "PRODUCT",
          "page" : {
            "sid" : "c781974f-66e2-41d5-a780-839077f6d86e",
            "name" : "CProduct List",
            "url" : "/cproduct/cproductlist"
          }
        }
      },
      "title" : "Product",
      "type" : "homeTile",
      "key" : "50667634-b478-4f19-b84d-59fe6277672b",
      "selected" : false
    }, {
      "expanded" : false,
      "folder" : false,
      "data" : {
        "properties" : {
          "accessControl" : [ "App Admin" ],
          "onClick" : "navigate_to_page",
          "outline" : false,
          "infiniteScroll" : false,
          "valueChange" : true,
          "currentNode" : "b5772e88-f9a9-49c7-8422-c7f087a5d1bf",
          "label" : "ORDER",
          "page" : {
            "sid" : "37771a8b-2c14-4527-b0e2-c8a7af2cf31c",
            "name" : "COrder List",
            "url" : "/corder/corderlist"
          }
        }
      },
      "title" : "Order",
      "type" : "homeTile",
      "key" : "b5772e88-f9a9-49c7-8422-c7f087a5d1bf",
      "selected" : false
    }, {
      "expanded" : false,
      "folder" : false,
      "data" : {
        "properties" : {
          "accessControl" : [ "App Admin" ],
          "onClick" : "navigate_to_page",
          "outline" : false,
          "infiniteScroll" : false,
          "valueChange" : true,
          "appId" : "ce0274a5-c894-44ff-965c-88530306f8d2",
          "currentNode" : "be1f70df-02db-40cf-8a05-4e925a695ed0",
          "tableId" : "6ebab0ab-4c1a-49e4-a501-0fd2917c9616",
          "label" : "COPVIEW",
          "page" : {
            "sid" : "b735c4bc-6747-4eb9-8e8d-bcbcf0d18a3c",
            "name" : "COPView List",
            "url" : "/copview/copviewlist"
          }
        }
      },
      "title" : "COPView",
      "type" : "homeTile",
      "key" : "be1f70df-02db-40cf-8a05-4e925a695ed0",
      "selected" : false
    } ],
    "title" : "Home Page",
    "type" : "homePage",
    "key" : "homePage",
    "selected" : false
  } ],
  "icon" : "page-icon",
  "title" : "Page",
  "type" : "page",
  "key" : "page",
  "selected" : false
} ];
  
 currentUserRoles = (this.appGlobalService.getCurrentUserData()).userRoles;
 checkAccess: any = (o: string) => this.currentUserRoles.includes(o);

  public getLandingPageData() {
    let accessibleData: any = {
      children: []
    };
    const data: any = (this.config.find((t: { type: string; }) => t.type === "page"))?.children[0];
    if (!environment.prototype) {
      data.children?.filter((tileProps: any) => {
        const tile = tileProps.data?.properties;
        if (tile.accessControl && tile.accessControl.length > 0) {
          if (tile.accessControl.some(this.checkAccess) || tile.accessControl.includes('all'))
            accessibleData.children.push(tileProps);
        }
        else {
          accessibleData.children.push(tileProps);
        }
      })
      accessibleData = { ...data, ...accessibleData };
    }
    else {

      accessibleData = data;
    }
    return accessibleData;
  }
}