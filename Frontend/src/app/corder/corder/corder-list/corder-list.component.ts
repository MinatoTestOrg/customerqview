import { Component, OnInit,inject } from '@angular/core';
import { CorderListBaseComponent } from '@baseapp/corder/corder/corder-list/corder-list.base.component';
import { CorderService } from '@baseapp/corder/corder/corder.service';


@Component({
  selector: 'app-corder-list',
  templateUrl: '../../../../../base/app/corder/corder/corder-list/corder-list.component.html',
  styleUrls: ['./corder-list.scss']
})
export class CorderListComponent extends CorderListBaseComponent implements OnInit {
 
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }

  ngOnChanges(changes:any){
    super.onChanges(changes);
  }
 
}