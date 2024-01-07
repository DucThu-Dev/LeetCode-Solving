interface JobDetail {
  startTime: number,
  endTime: number,
  profit: number,
}

function jobScheduling(startTime: number[], endTime: number[], profit: number[]): number {
  let totalJobs = startTime.length
  let jobDetails: Array<JobDetail> = []

  for (let i = 0; i < totalJobs; i++) {
    jobDetails.push({
      startTime: startTime[i],
      endTime: endTime[i],
      profit: profit[i]
    })
  }

  jobDetails.sort((job1, job2) => job1.endTime - job2.endTime)

  let dp = new Array<number>(totalJobs + 1).fill(0)

  for (let i = 0; i < totalJobs; i++) {
    let currentJob = jobDetails[i]
    dp[i + 1] = Math.max(dp[i], dp[getLastestJobNotConflict(i, currentJob.startTime)] + currentJob.profit)
  }

  function getLastestJobNotConflict(endIndex: number, targetEndTime: number) {
    let start = 0, end = endIndex;
    while (start < end) {
      let mid = start + ((end - start) / 2 >> 0)
      if (jobDetails[mid].endTime <= targetEndTime) {
        start = mid + 1;
      } else {
        end = mid;
      }
    }

    return start;
  }

  return dp[totalJobs]
};