import { Pipe, PipeTransform } from '@angular/core';
import {Note} from '../model/note';

@Pipe({
  name: 'searchTextFilter'
})
export class SearchTextFilterPipe implements PipeTransform {

  transform(notes: Note[], text: string): Note[] {
    if (text == null || text === '') {
      return notes;
    }
    return notes.filter(n => n.title.includes(text) || n.content.includes(text));
  }

}
