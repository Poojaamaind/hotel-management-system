import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookRoomComponent } from './book-room/book-room.component';
import { RoomHomeComponent } from './room-home/room-home.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [BookRoomComponent, RoomHomeComponent],
  imports: [
    CommonModule,FormsModule
  ],exports:[BookRoomComponent,RoomHomeComponent]
})
export class BookingModule { }
