import { Component, OnInit,inject } from '@angular/core';
import { CopviewDetailBaseComponent } from '@baseapp/copview/copview/copview-detail/copview-detail.base.component';
import { CopviewService } from '@baseapp/copview/copview/copview.service';


@Component({
  selector: 'app-copview-detail',
  templateUrl: '../../../../../base/app/copview/copview/copview-detail/copview-detail.component.html',
  styleUrls: ['./copview-detail.scss']
})
export class CopviewDetailComponent extends CopviewDetailBaseComponent implements OnInit {
 
	
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