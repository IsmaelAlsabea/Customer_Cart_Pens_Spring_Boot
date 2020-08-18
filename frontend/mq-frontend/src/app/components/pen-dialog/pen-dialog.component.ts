import { Component, OnInit, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from "@angular/material/dialog";
import { Pen } from '../../models/pen'
import { PenService } from 'src/app/services/pen.service';


@Component({
  selector: 'app-pen-dialog',
  templateUrl: './pen-dialog.component.html',
  styleUrls: ['./pen-dialog.component.css']
})
export class PenDialogComponent implements OnInit {

  constructor(
    public dialogRef:MatDialogRef<PenDialogComponent>,
    private penService:PenService,
    @Inject(MAT_DIALOG_DATA) public data:any ) { }

  specificPen:Pen;

  ngOnInit(): void {
    this.getPenDetails(this.data);
  }

  close() {
    this.dialogRef.close();
  }

  async getPenDetails(id:number) {
    const pen = await this.penService.getPenById(id);
    console.log(pen);
    this.specificPen = pen;
  }

}
