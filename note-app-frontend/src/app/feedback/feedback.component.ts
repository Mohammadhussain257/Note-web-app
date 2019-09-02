import { Component, OnInit } from '@angular/core';
import {AppService} from '../shared/app-service';
import {Feedback} from '../model/feedback';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent implements OnInit {
feedback: Feedback = {
  id: 0,
  fullName: '',
  email: '',
  message: ''
}
  constructor(private apiService: AppService) { }

  ngOnInit() {
  }

  sendFeedback(): void {
  this.apiService.sendFeedback(this.feedback).subscribe(
    res => {
      location.reload();
    },
    err => {
      alert('An error occurred while sending feedback');
    }
  );
  }
}
