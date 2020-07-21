import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, FormBuilder, FormArray, Validators} from '@angular/forms';

@Component({
  selector: 'app-name-editor',
  templateUrl: './name-editor.component.html',
  styleUrls: ['./name-editor.component.css']
})
export class NameEditorComponent implements OnInit {
  name = new FormControl();
  profileForm = new FormGroup(
    {
      firstName: new FormControl(),
      lastName: new FormControl(),
      address: new FormGroup({
        city: new FormControl(),
        state: new FormControl()
      })
    }
  );
  profileForm2 = this.fb.group({
    firstName: ['', Validators.required],
    lastName: [''],
    address: this.fb.group({
      street: [''],
      city: [''],
      state: [''],
      zip: ['']
    }),
    aliases: this.fb.array(
      [this.fb.group({
        name2: [''],
        age2: ['']
      })]
    )
  });

  constructor(private fb: FormBuilder) {
  }

  ngOnInit() {
  }

  get aliases() {
    return this.profileForm2.get('aliases') as FormArray;
  }

  addAlias() {
    this.aliases.push(this.fb.group({
      name2: [''],
      age2: ['']
    }));
  }

  updateName() {
    this.name.setValue('nancy');
  }

  onSubmit() {
    console.warn(this.profileForm2.value);
  }

  updateProfile() {
    this.profileForm2.patchValue(
      {
        firstName: 'Leon',
        address: {
          city: 'Da Nang'
        }
      }
    );
  }

  // Form Builder//

}
