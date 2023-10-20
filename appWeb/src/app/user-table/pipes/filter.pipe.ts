import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {


    transform(value: any, arg: any): any {
      if (!arg) return value;
      const resultPosts = [];
      for (const post of value) {
        if (post.name.toLowerCase().includes(arg.toLowerCase())) {
          resultPosts.push(post);
        }
      }
      return resultPosts;
    }
}


