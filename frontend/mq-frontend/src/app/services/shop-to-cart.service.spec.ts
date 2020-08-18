import { TestBed } from '@angular/core/testing';

import { ShopToCartService } from './shop-to-cart.service';

describe('ShopToCartService', () => {
  let service: ShopToCartService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShopToCartService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
