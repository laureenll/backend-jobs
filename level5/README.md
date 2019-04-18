# Level 5

This level is a little bit different: we are now looking for a live application that helps us manage workers and shift.

We are expecting a link to a hosted application that enable us to:
- add and edit workers
- add and assign shifts
- consult shifts

The application should be as simple as possible (for example, authentication is not expected).

## Documentation
### How it's work

You can run the application and then some data will be add by default to fake database.
The database is fake because it's only two global lists (list of workers and list of shifts).
Then we have two controller to do action on items in database. 

### Data test
workers: 
```json
[
    {id: "1", firstname: "michel", status: "interim"},
    {id: "2", firstname: "paul", status: "interne"},
    {id: "3", firstname: "eric", status: "medic"}
]
```

shifts: 
```json
[
    {id: "1", startDate: "2019-04-18", workerId: "1"},
    {id: "2", startDate: "2019-04-18"},
    {id: "3", startDate: "2019-04-18"}
]
```

### API
#### Worker 

- Request all workers

`GET /worker` 

- Add worker

`POST /worker` 
<br/>
Params: RequestWorker {String: firstname, Status: status}

- Update worker

`PUT /worker/:id`
<br/>
Params: RequestWorker {String: firstname, Status: status}

#### Shift 

- Request all shifts

`GET /shifts` 

- Add shift

`POST /shift` 
<br/>
Params: RequestShift {Date: startDate}

- Assign worker to shift

`PUT /shift/:shiftId/:workerId`

