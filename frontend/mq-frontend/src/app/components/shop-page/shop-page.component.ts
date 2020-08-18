import { Component, OnInit } from '@angular/core';
import { Pen } from '../../models/pen'
import { PenService } from 'src/app/services/pen.service';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { PenDialogComponent } from 'src/app/components/pen-dialog/pen-dialog.component'


@Component({
  selector: 'app-shop-page',
  templateUrl: './shop-page.component.html',
  styleUrls: ['./shop-page.component.css']
})
export class ShopPageComponent implements OnInit {

  constructor(private matDialog:MatDialog, private penService:PenService) { }

  ngOnInit(): void {
    this.displayPens();
  }

  pens:Array<Pen> = [];

  async displayPens():Promise<void>{
      this.pens = await this.penService.getAllPens();
  };

  openDialog(id:Number) {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = id;
    this.matDialog.open(PenDialogComponent, dialogConfig);
  }

}