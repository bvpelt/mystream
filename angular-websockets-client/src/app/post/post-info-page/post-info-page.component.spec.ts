import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostInfoPageComponent } from './post-info-page.component';

describe('PostInfoPageComponent', () => {
  let component: PostInfoPageComponent;
  let fixture: ComponentFixture<PostInfoPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostInfoPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostInfoPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
