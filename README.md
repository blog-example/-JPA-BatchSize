# N + 1 정복

### Branches <br/>
1. N + 1 발생 ([블로그](https://iwsaitw.tistory.com/entry/N-1-정복하기))
    - 최초에 n + 1이 발생하는 코드가 들어있습니다.

    <br />
    
2. eager ([블로그](https://iwsaitw.tistory.com/entry/N-1-정복하기-2-FetchTypeEAGER))
   - FetchType.EAGER 사용하는 예제 

<br />

3. JPQL-@Query / JPQL-EM ([블로그](https://iwsaitw.tistory.com/entry/N-1-정복하기-3-Fetch-Join))
   - JPQL-@Query는 repository에서 @Query를 사용해서 N + 1을 해결하는 예제
   - JPQL-EM은 service에서 Entity Manager를 사용해서 N + 1을 해결하는 예제

<br />

4. BatchSize ([블로그](https://iwsaitw.tistory.com/entry/N-1-정복하기-4-BatchSize))
   - @BatchSize를 적용하는 예제