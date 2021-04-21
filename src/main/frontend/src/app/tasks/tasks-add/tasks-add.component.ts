import {Component, OnInit} from '@angular/core';
import {TaskService} from "../task.service";
import {Task} from "../task.model";
import {formatDate} from '@angular/common';

@Component({
  selector: 'app-tasks-add',
  templateUrl: './tasks-add.component.html',
  styleUrls: ['./tasks-add.component.scss']
})
export class TasksAddComponent implements OnInit {
    //null no longer usable with strings
    addTaskValue: string = '';

  constructor(private taskService: TaskService) { }

  ngOnInit() {
  }

  onTaskAdd(event: Event){
      let task: Task = new Task((<HTMLInputElement>event.target).value, false, this.getTodayAsString());
      this.taskService.addTask(task).subscribe(
          (newTask: any) => {
              //clear the input
                this.addTaskValue = '';
                this.taskService.onTaskAdded.emit(newTask);
          }
      );
  }

  getTodayAsString(){
      //replaced old dirty date code with formatDate object so proper date is returned (locale not normally hardcoded
      //but done here for simplicity...)
      //Also this would never be used as it's a due date! A date/time picker would be ideal here...
      return formatDate(new Date(), "MM/dd/yyyy", "en");
  }
}
