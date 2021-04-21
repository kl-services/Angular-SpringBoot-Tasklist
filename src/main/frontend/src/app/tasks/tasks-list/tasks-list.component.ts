import { Component, OnInit } from '@angular/core';
import {Task} from "../task.model";
import {TaskService} from "../task.service";
import {any} from "codelyzer/util/function";
import {error} from "@angular/compiler/src/util";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-tasks-list',
  templateUrl: './tasks-list.component.html',
  styleUrls: ['./tasks-list.component.scss']
})
export class TasksListComponent implements OnInit {

    tasks: any = [];

  constructor(private taskService: TaskService) { }

  ngOnInit() {
      //NOTE: DON'T FORGET TO REMOVE :void FROM ABOVE!!!
      //Also bad practice to use 'any[]' (except for global variable) - replaced with {}
      //the following is now replaced with a Spring hook (service)
      /*this.tasks.push(new Task(1, "Task 1", true, "04/14/21"));
      this.tasks.push(new Task(2, "Task 2", false, "04/14/21"));
      this.tasks.push(new Task(3, "Task 3", false, "04/14/21"));*/


      this.taskService.getTasks().subscribe(
          (tasks: {}) => {
              this.tasks = tasks
          }, (error) => console.log(error));

        this.taskService.onTaskAdded.subscribe(
            (task:Task) => this.tasks.push(task)
        );
  }





    onTaskChange(event: Event, task: Task) {
        this.taskService.saveTask(task, (<HTMLInputElement>event.target).checked).subscribe();
    }

    getDueDateLabel(task: Task) {
        return task.completed ? 'badge-success' : 'badge-primary';
    }
}
